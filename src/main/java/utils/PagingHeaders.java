package utils;



public enum PagingHeaders {
    PAGE_SIZE("Page-Size"),
    PAGE_NUMBER("Page-Number"),
    PAGE_OFFSET("Page-Offset"),
    PAGE_TOTAL("Page-Total"),
    COUNT("Count");

    PagingHeaders(String string) {
		this.name = string;
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	public String getName() {
		return name;
	}
}