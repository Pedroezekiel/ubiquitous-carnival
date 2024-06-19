package pratice;

import java.util.List;

public class Pagination {
    public static void main(String[] args) {

        // to 25
        List<Integer> numbers = List.of(1, 2,3,4,5,6,7,8, 9,10);
        System.out.println(getPaginationResponse(numbers, 0, 10).getContent());


    }

    private static PaginationResponse getPaginationResponse(List<Integer> numbers, int pageNo, int pageSize) {
        PaginationResponse response = new PaginationResponse(0, 0, 0, 0, false, false, 0, true, List.of());
        if (pageSize == 0){
            pageSize = 10;
        }
        if (numbers.isEmpty()) {
            response = new PaginationResponse(0, 0, 0, 0, false, false, 0, true, List.of());
        } else if (pageSize > numbers.size() && pageNo == 0) {
            response = new PaginationResponse(numbers.size(), pageNo, pageSize, 1, false, false, numbers.size(), true, numbers);
        } else if (pageSize >= numbers.size() && pageNo > 0){
            return new PaginationResponse(0, 0, 0, 0, false, false, 0, true, List.of());
        } else {
            int availablePages = getAvailablePages(numbers.size(), pageSize);
            int lastPage = isLastPage(availablePages, pageNo);
            if (lastPage <= 0) {
                response = new PaginationResponse(0, 0, 0, 0, false, false, 0, true, List.of());
            } else if (lastPage == 1) {
                int remainder = numbers.size() % pageSize;
                if (remainder == 0){
                    int formIndex = numbers.size() - remainder;
                    if(numbers.size() == pageSize){
                        response = new PaginationResponse(numbers.size(), pageNo, pageSize, availablePages, pageNo > 1, false, numbers.size(), true, numbers);
                    }else {
                        response = new PaginationResponse(numbers.size(), pageNo, pageSize, availablePages, pageNo > 1, false, numbers.size(), true, numbers.subList(formIndex, numbers.size() - 1));
                    }
                } else {
                    response = getPageData(numbers, pageNo, pageSize, availablePages, lastPage);
                }
            }else {
                response = getPageData(numbers, pageNo, pageSize, availablePages, lastPage);
            }
        }
        return response;
    }

    private static PaginationResponse getPageData(List<Integer> numbers, int pageNo, int pageSize, int availablePages, int lastPage) {
        int formIndex = pageNo * pageSize;
        int toIndex = formIndex + pageSize;
        if (lastPage == 1) {
            toIndex = numbers.size();
        }
        System.out.println("formIndex: " + formIndex + " toIndex: " + toIndex);
        List<Integer> content = numbers.subList(formIndex, toIndex);
        boolean hasNext = pageNo < availablePages;
        boolean hasPrevious = pageNo > 1;
        boolean isLast = lastPage == 1;
        return new PaginationResponse(numbers.size(), pageNo, pageSize, availablePages, hasPrevious, hasNext, numbers.size(), isLast, content);
    }

    private static int isLastPage(int availablePages, int pageNo) {
        return availablePages - pageNo;
    }

    private static int getAvailablePages(int size, int pageSize) {
        int availablePages = size / pageSize;
        if (size % pageSize > 0) {
            availablePages++;
        }
        return availablePages;
    }
}