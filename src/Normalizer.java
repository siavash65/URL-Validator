
public final class Normalizer {
	
	private static URL normalURL;
	public static URL nomalize(URL url){
		normalURL = new URL();
		normalURL.setSchemeName(url.getSchemeName().toLowerCase());
		if(!url.getPortNumber().isEmpty()){
			int portNumber = Integer.parseInt(url.getPortNumber());
			if(portNumber == 21 || portNumber == 20 || portNumber == 80 || portNumber == 443){
				normalURL.setPortNumber("");
			}
			else{
				normalURL.setPortNumber(url.getPortNumber());
			}
		}
			String domain = url.getDomainName().toLowerCase();
			if(domain.contains("www")){
				normalURL.setDomainName(domain.substring(domain.indexOf("www")+4));
			}
			else{
				normalURL.setDomainName(domain);
			}
				normalURL.setIPAddress(url.getIPAddress());
				normalURL.setUserInfo(url.getUserInfo());
				normalURL.setPath(url.getPath());
		
		
		return normalURL;
	}
}
