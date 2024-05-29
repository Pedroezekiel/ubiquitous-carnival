package pratice;

import java.util.List;

public class PaginationResponse {

    private int page;
    private int pageSize;
    private int totalPages;
    private boolean hasPrevious;
    private boolean hasNext;
    private int totalElements;
    private boolean isLast;
    private List<Integer> content;

    public PaginationResponse(int total, int page, int pageSize, int totalPages, boolean hasPrevious, boolean hasNext, int totalElements, boolean isLast, List<Integer> content) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.totalElements = totalElements;
        this.isLast = isLast;
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public List<Integer> getContent() {
        return content;
    }

    public void setContent(List<Integer> content) {
        this.content = content;
    }



}
