package com.jm.portfolio.global.common.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingDTO {
    private int pageStart;			// 페이지 시작 번호
    private int pageEnd;			// 페이지 끝 번호
    private boolean next, prev;		// 이전, 다음 버튼 존재 유무
    private int total;			    // 행 전체 개수

    /* 현재페이지 번호(pageNum), 행 표시 수(amount), 검색 키워드(keyword), 검색 종류(type) 등*/
    private PagingCriteria cri;			// 검색 정보

    /* 생성자(클래스 호출 시 각 변수 값 초기화) */
    public PagingDTO(PagingCriteria cri, int total) {

        /* cri, total 초기화 */
        this.cri = cri;
        this.total = total;

        /* 페이지 끝 번호 */
        this.pageEnd = (int) (Math.ceil(cri.getPageNo() / 10.0)) * 10;

        /* 페이지 시작 번호 */
        this.pageStart = this.pageEnd - 9;

        /* 전체 마지막 페이지 번호 */
        int finalEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));

        /* 페이지 끝 번호 유효성 체크 */
        if (finalEnd < pageEnd) {
            this.pageEnd = finalEnd;
        }

        /* 이전 버튼 값 초기화 */
        this.prev = this.pageStart > 1;

        /* 다음 버튼 값 초기화 */
        this.next = this.pageEnd < finalEnd;
    }
}