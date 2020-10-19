package utils;

import com.asofi.servrest.entity.Empresa;
import com.asofi.servrest.entity.Riesgo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * DTO using for pagination
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PagingResponse {
	
	public PagingResponse(Long count, Long pageNumber, Long pageSize, Long pageOffset, Long pageTotal,
			List<Empresa> elements) {
		super();
		this.count = count;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.pageOffset = pageOffset;
		this.pageTotal = pageTotal;
		this.elements = elements;
	}

	public PagingResponse(Long count, Long pageNumber, Long pageSize, Long pageOffset, Long pageTotal,
			List<Riesgo> elements , int i) {
		super();
		this.count = count;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.pageOffset = pageOffset;
		this.pageTotal = pageTotal;
		this.elementsr = elements;
	}

	/**
     * entity count
     */
	@Getter
	@Setter
    private Long count;
    /**
     * page number, 0 indicate the first page.
     */
	@Getter
	@Setter
    private Long pageNumber;
    /**
     * size of page, 0 indicate infinite-sized.
     */
	@Getter
	@Setter
    private Long pageSize;
    /**
     * Offset from the of pagination.
     */
	@Getter
	@Setter
    private Long pageOffset;
    /**
     * the number total of pages.
     */
	@Getter
	@Setter
    private Long pageTotal;
    /**
     * elements of page.
     */
	@Getter
	@Setter
    private List<Empresa> elements;
	
	@Getter
	@Setter
    private List<Riesgo> elementsr;
	public List<Riesgo> getElementsr() {
		return elementsr;
	}

	public void setElementsr(List<Riesgo> elementsr) {
		this.elementsr = elementsr;
	}

	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(Long pageOffset) {
		this.pageOffset = pageOffset;
	}
	public Long getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Long pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List<Empresa> getElements() {
		return elements;
	}
	public void setElements(List<Empresa> elements) {
		this.elements = elements;
	}
}
