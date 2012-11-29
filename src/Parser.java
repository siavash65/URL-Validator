public final class Parser {
	
	private static URL myURL;
	public static boolean parse(String url){
		return syntaxChecker(url);
		
	}
		
	private static boolean syntaxChecker(String url) {
		try {
			if(tokenize(url)){
				return true;
			}
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			return false;
		}
		return true;	
	}

	private static boolean tokenize(String url) throws Exception{
		
		myURL = new URL();
		int indexOfColon = url.indexOf("://");
		if ( indexOfColon == -1){ //url does not contain ://
			throw new Exception("URL does not contain :// therefore its not valid");
		}
		else{
			String scheme = url.substring(0, indexOfColon);
			
			if(isSchemeNameValid(scheme)){
				myURL.setSchemeName(scheme);
			}
			else{
				throw new Exception("Scheme name is not valid");
			}
		}
		int indexOfAtSign = url.indexOf('@');
		if( indexOfAtSign != -1){ // we have the optional user info
		  myURL.setUserInfo(url.substring(indexOfColon, indexOfAtSign));
		}
		int indexOfSlashAfterDomain = url.indexOf('/', indexOfColon+3);
		if(indexOfSlashAfterDomain == -1){
			throw new Exception("The URL is not valid. No slash was found after domain name");
		}
		else{//its either domain name or IP Address
			if(myURL.getUserInfo().compareToIgnoreCase("") == 0){//no user info. domain starts after ://
				String domainOrIP = url.substring(indexOfColon+3, indexOfSlashAfterDomain);
				
				if(domainOrIP.contains(":")){//domain contains port number
					int indexOfColonBeforPortNumber = domainOrIP.indexOf(':');
					boolean isDomain = isDomaneNameValid(domainOrIP.substring(0, indexOfColonBeforPortNumber));
					
					if(isDomain){
						myURL.setDomainName(domainOrIP.substring(0, indexOfColonBeforPortNumber));
						boolean isPortNumber = isPortNumberValid(domainOrIP.substring(indexOfColonBeforPortNumber+1));
						if(isPortNumber){
							myURL.setPortNumber(domainOrIP.substring(indexOfColonBeforPortNumber+1));
						}
						else{
							throw new Exception("The port number is not valid");
						}
						
					}
					else
					{
						throw new Exception("The domain name or IP Address is not valid");
					}	
				}
				else{
					boolean isDomain = isDomaneNameValid(domainOrIP);
					boolean isIP = isIPAddressValid(domainOrIP);
					if(!isDomain && !isIP){
						throw new Exception("The domain name or IP Address is not valid");
					}
					else{
						if(isDomain){
							myURL.setDomainName(domainOrIP);
						}
						else{
							myURL.setIPAddress(domainOrIP);
						}
					}
				}
				int indexOfPath = indexOfSlashAfterDomain + 1;
				String restOfURL = url.substring(indexOfPath);
				if(restOfURL.contains("#")){//has fragment
					myURL.setPath(restOfURL.substring(0, restOfURL.indexOf("#")));// path
					myURL.setFragment(restOfURL.substring(restOfURL.indexOf("#")+1));
				}
				else if(restOfURL.contains("?")){ //has query
					int indexOfQuery = restOfURL.lastIndexOf("/") + 1;
					myURL.setPath(restOfURL.substring(0, indexOfQuery));
					myURL.setQuery(restOfURL.substring(indexOfQuery));
					
				}
				else{
					myURL.setPath(restOfURL);
				}
			}	
		}
		return true;//the url is valid if we havent throw any exception
	}


	private static boolean isPortNumberValid(String portNumber) {
		String scheme =  myURL.getSchemeName().toLowerCase();
		int portN = Integer.parseInt(portNumber);
		switch(scheme){
		case "http":
			if(portN == 80){
				return true;
			}
			else
			{
				return false;
			}
		case "https":
			if(portN == 443){
				return true;
			}
			else
			{
				return false;
			}
		case "ftp":
			if(portN == 20 || portN == 21){
				return true;
			}
			else
			{
				return false;
			}
		default:
			if(portN >= 0 && portN < 65535){
				return true;
			}
			else{
				return false;
			}
		}
	}


	private static boolean isIPAddressValid(String domainOrIP) {//validates only IP version 4
		if(domainOrIP.isEmpty()){
			return false;
		}
		else{
			
		String[] parts = new String[4];
		parts = domainOrIP.split("[.]");
		
		if(parts.length < 4){
			return false;
		}
		else{
			return true;
		}
		}
	}


	private static boolean isDomaneNameValid(String domainOrIP) {
		if(domainOrIP.isEmpty()){
			return false;
		}
		else if(domainOrIP.contains(".aero") ||
		   domainOrIP.contains(".asia") ||
		   domainOrIP.contains(".biz") ||
		   domainOrIP.contains(".cat") ||
		   domainOrIP.contains(".com") ||
		   domainOrIP.contains(".coop") ||
		   domainOrIP.contains(".edu") ||
		   domainOrIP.contains(".gov") ||
		   domainOrIP.contains(".info") ||
		   domainOrIP.contains(".int") ||
		   domainOrIP.contains(".jobs") ||
		   domainOrIP.contains(".mil") ||
		   domainOrIP.contains(".mobi") ||
		   domainOrIP.contains(".museum") ||
		   domainOrIP.contains(".name") ||
		   domainOrIP.contains(".net") ||
		   domainOrIP.contains(".org") ||
		   domainOrIP.contains(".pro") ||
		   domainOrIP.contains(".tel") ||
		   domainOrIP.contains(".travel") ||
		   domainOrIP.contains(".xxx") 
		   )// The generic top level domains
		{
			return true;
		}
		return false;
	}


	private static boolean isSchemeNameValid(String scheme) {
		if(scheme.isEmpty()){
			return false;
		}
		else if(scheme.compareToIgnoreCase("http") == 0 ||
		   scheme.compareToIgnoreCase("https") == 0 ||
		   scheme.compareToIgnoreCase("ftp") == 0){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	public static URL getURL(){
		return myURL;
	}
}
