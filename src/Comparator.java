
public final class Comparator {
	
	public static int compare(URL first, URL second){
		
		if(first.getSchemeName().compareTo(second.getSchemeName()) != 0){
			return first.getSchemeName().compareTo(second.getSchemeName());
		}
		else if(!first.getUserInfo().isEmpty() &&
				first.getUserInfo().compareTo(second.getUserInfo()) != 0){
				return first.getUserInfo().compareTo(second.getUserInfo());
			}
		else if(!first.getDomainName().isEmpty() &&
				first.getDomainName().compareTo(second.getDomainName()) != 0){
				return first.getDomainName().compareTo(second.getDomainName());
			}
		else if(!first.getIPAddress().isEmpty() && first.getIPAddress().compareTo(second.getIPAddress()) !=0){
			return first.getIPAddress().compareTo(second.getIPAddress());
		}
		else if(!first.getPortNumber().isEmpty() &&
				first.getPortNumber().compareTo(second.getPortNumber()) != 0){
				return first.getPortNumber().compareTo(second.getPortNumber());
			}
		else if(!first.getPath().isEmpty() &&
				first.getPath().compareTo(second.getPath()) != 0){
				return first.getPath().compareTo(second.getPath());
			}
		else if(!first.getQuery().isEmpty() &&
				first.getQuery().compareTo(second.getQuery()) != 0){
				return first.getQuery().compareTo(second.getQuery());
			}
		else if(!first.getFragment().isEmpty() &&
				first.getFragment().compareTo(second.getFragment()) != 0){
				return first.getFragment().compareTo(second.getFragment());
			}
		else return 0;	
	}
}
