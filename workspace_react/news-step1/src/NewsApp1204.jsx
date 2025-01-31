import axios from "axios";
import { Fragment, useState, useEffect } from "react";
import NewsList1204 from "./componects1204/NewsList1204";

const NewsApp1204 = () => {
  console.log(1)
  // 뉴스 목록을 담을 배열 객체 선언
  const [newsList, setNewsList] = useState([]);
  const NEWS_URL = "https://api.hnpwa.com/v0/news/1.json"

  // useEffect훅을 사용한다. - 함수이다.(Hook)
  // 특이점은 파라미터로 의존성 배열을 지원을 받는다.(렌더링과 밀접한 관계-중요)

  useEffect(() => {
    console.log(2)
    // axios를 사용하면 비동기 처리가 가능하다.
    axios.get(NEWS_URL)
    .then((res) => {
      console.log(res)
      setNewsList(res.data)
    })
  }, []); // 의존성 배열을 추가한다. - 만일 빈 배열이면 단 한번만 useEffect가 실행된다.
  console.log(3)
  console.log(newsList.length) // 30

  return (
    <>
      <NewsList1204 newsList={newsList}/>
    </>
  );
}

export default NewsApp1204;
