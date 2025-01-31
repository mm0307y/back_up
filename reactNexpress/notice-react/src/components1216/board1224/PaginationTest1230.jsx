import React, { useState } from 'react'
import { Pagination } from 'react-bootstrap';

const PaginationTest1230 = () => {
  const items = Array.from({ length: 55 }, (_, i) => `item ${i + 1}`)
  const itemsPerPage = 5 // 페이지 당 항목 수
  const [currentPage, setCurrentPage] = useState(1) // 현재 상태를 관리하는 훅
  const totalPages = Math.ceil(items.length / itemsPerPage)

  // 마지막 항목인데스 : 현재페이지와 페이징당 항목 수를 곱하여 계산
  // -> 5, 10, 15, 20, 25, 30, 35, 40, 45, 50
  const indexOfLastItem = currentPage * itemsPerPage

  // 첫번쨰 항목 인덱스 : 마지막 항목 인덱스에서 페이지당 항목 수를 뺀값
  const indexOffFirstItem = indexOfLastItem - itemsPerPage

  // 현재 페이지 항목 - 현재 페이지에 표시할 데이터를 추출하기
  const currentItems = items.slice(indexOffFirstItem, indexOfLastItem)

  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber)
  }

  return (
    <>
      <div className='container mt-4'>
        <h2>페이징 처리 연습</h2>
        <ul>
          {currentItems.map((item, index) => (
            <li key={index} className='list-group mb-3' >{item}</li>
          ))}
        </ul>
        <div className='d-flex justify-content-center'>
          <Pagination>
            <Pagination.First
              onClick={() => handlePageChange(1)}
              disabled={currentPage === 1}
            />
            <Pagination.Prev
              onClick={() => handlePageChange(currentPage - 1)}
              disabled={currentPage === 1}
            />
            {
              Array.from({ length: totalPages }, (_, i) => i + 1).map((pageNumber) => (
                <Pagination.Item active={currentPage === pageNumber} key={pageNumber} onClick={() => handlePageChange(pageNumber)}>{pageNumber}</Pagination.Item>
              ))
            }
            <Pagination.Next
              onClick={() => handlePageChange(currentPage + 1)}
              disabled={currentPage === Math.ceil(items.length / itemsPerPage)}
            />
            <Pagination.Last
              onClick={() => handlePageChange(Math.ceil(items.length / itemsPerPage))}
              disabled={currentPage === Math.ceil(items.length / itemsPerPage)}
            />
          </Pagination>
        </div>
      </div>
    </>
  );
}

export default PaginationTest1230