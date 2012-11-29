
class URL {
	
	private String schemeName;
	private String userInfo;
	private String domainName;
	private String ipAddress;
	private String portNumber;
	private String path;
	private String query;
	private String fragment;
	
	
	public URL(){
		this.schemeName = "";
		this.userInfo = "";
		this.domainName = "";
		this.ipAddress = "";
		this.portNumber = "";
		this.path = "";
		this.query = "";
		this.fragment = "";
		
	}
	
	
	public void setSchemeName(String scheme){
		
		this.schemeName = scheme;
	}
	
	public void setUserInfo(String userInfo){
		
		this.userInfo = userInfo;
	}

	public void setDomainName(String domainName){
		
		this.domainName = domainName;
	}
	
	public void setIPAddress(String ipAddress){
		
		this.ipAddress = ipAddress;
	}
	
	public void setPortNumber(String portNumber){
		
		this.portNumber = portNumber;
	}
	
	public void setPath(String path){
		
		this.path = path;
	}
	
	public void setQuery(String query){
		
		this.query = query;
	}
	
	public void setFragment(String fragment){
		
		this.fragment = fragment;
	}
	
	public String getSchemeName(){
		
		return this.schemeName;
	}
	
	public String getUserInfo(){
		
		return this.userInfo;
	}

	public String getDomainName(){
		
		return this.domainName;
	}
	
	public String getIPAddress(){
		
		return this.ipAddress;
	}
	
	public String getPortNumber(){
		
		return this.portNumber;
	}
	
	public String getPath(){
		
		return this.path;
	}
	
	public String getQuery(){
		
		return this.query;
	}
	
	public String getFragment(){
		
		return this.fragment;
	}
	
	public String toString(){
		String url = "";
		url += schemeName + "://";
		if(!userInfo.isEmpty()){
			url += userInfo + "@";
		}
		if(!domainName.isEmpty()){
			url += domainName;
			if(!portNumber.isEmpty()){
				url += ":" + portNumber; 
			}
		}
		else{
			url += ipAddress;
			if(!portNumber.isEmpty()){
				url += ":" + portNumber; 
			}
		}
		if(!path.isEmpty()){
			url += ":" + path;
		}
		if(!query.isEmpty()){
			url += "/" + query;
		}
		if(!fragment.isEmpty()){
			url += fragment;
		}
		return url;
	}
}
