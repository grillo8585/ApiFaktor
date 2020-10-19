package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum PagingHeaders {
	@Getter
	@Setter
    PAGE_SIZE("Page-Size"),
    @Getter
    @Setter
    PAGE_NUMBER("Page-Number"),
    @Getter
    @Setter
    PAGE_OFFSET("Page-Offset"),
    @Getter
    @Setter
    PAGE_TOTAL("Page-Total"),
    @Getter
    @Setter
    COUNT("Count");

    PagingHeaders(String string) {
		this.name = string;
		// TODO Auto-generated constructor stub
	}
    @Getter
    @Setter
	private final String name;
	public String getName() {
		return name;
	}
}