
public final class urlInfo {
	
	private  URL url;
	private  URL normalurl;
	private String source;
	private String normalForm;
	private boolean isSourceUnique;
	private boolean isNormalUnique;
	private boolean isValid;
	
	
	public  urlInfo(URL url,
			URL normalurl,
			String source,
			String normalForm, 
			boolean isSourceUnique, 
			boolean isNormalUnique,
			boolean isValid){
		this.url = url;
		this.normalurl = normalurl;
		this.source = source;
		this.normalForm = normalForm;
		this.isSourceUnique = isSourceUnique;
		this.isNormalUnique = isNormalUnique;
		this.isValid = isValid;
	}
	
	public String toString(){
		String info = "";
		info += "Source: " + this.source +"\n" ;
		info += "Valid: " + this.isValid + "\n";
		
		
		if(this.isValid){
			info += "Canonical: " + this.normalForm + "\n";
			this.isSourceUnique = isSourceUnique(this.url);
			this.isNormalUnique = isNormalUnique(this.normalurl);
			info += "Source unique: " + this.isSourceUnique + "\n";
			info += "Canonicalized URL unique: " + this.isNormalUnique + "\n";
		}
		else{
			info += "Canonical: N/A The URL is invalid" + "\n";
			info += "Source unique: N/A The URL is invalid" + "\n";
			info += "Canonicalized URL unique: N/A The URL is invalid" + "\n";
		}
		return info;
	}
	
	private boolean isNormalUnique(URL url2) {
		int found = 0;
		for(URL url: Main.normalurls){
			if(Comparator.compare(this.url, url) == 0){
				found++;
			}
		}
		return found == 1? true: false;
	}

	private  boolean isSourceUnique(URL sourceURL) {
		int found = 0;
		for(URL url: Main.urls){
			if(Comparator.compare(this.url, url) == 0){
				found++;;
			}
		}
		return found == 1? true: false;
	}
}
