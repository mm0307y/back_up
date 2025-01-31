import axios from "axios";
import { Fragment, useEffect, useState } from "react";
import YoutubList1213 from "./components1213/YoutubList1213";

const YoutubeApp1213 = () => {
  console.log('YoutubeApp1213')

  const [videos, setVideos] = useState([])
  const [params, setParams] = useState({
    part: 'snippet',
    q: '손흥민',
    maxResults: 25,
    key: "AIzaSyB3s74a5_0cgFU2HvL8O-eBsGLugxx9w94"
  })

  useEffect(() => {
    console.log('effect')
    axios.get('', { params })
    axios.get('https://www.googleapis.com/youtube/v3/search?', { params })
      .then(result => {
        setVideos(result.data.items)
      }).catch(error => console.log(error))
  }, []) // 의존성배열리 깡통이면 최초 한번만 실행된다.
  console.log(videos)

  return (
    <Fragment>
      <YoutubList1213 videos={videos} />
    </Fragment>
  );
}

export default YoutubeApp1213;
/* 
유튜브 서버에 인기동영상 요청하기
다른 외부서버에 요청할 때 restful API사용 - GET방식요청 한다. - 퀴리스트링한다.
외부 서버에 요청시에는 비동기 처리할 것.
new Promise는 바닐라 스크립트 제공한다.
axios 라이브러리 사용한다.
요청 결과로 배열을 받아서 useState에 담는다. - setter함수 사용한다.
두번째 파라미터 자리가  setter 함수 자리이다.
저장할 때 사용하고 값을 추가하는 방법은 파라미터를 사용한다.
상속관계 표현해 본다.
YoutubeApp1213 -> YoutubeList1213 -> YoutubeItem1213
상위 노드에서 하위 노드로 주소번지를 전달할 수 있지만 반대는 불가하다.
만일 꼭하고 싶다면 부모로부터 받은 함수의 주소번지를 자손태그에서 호출할 때
파라미터로 넘길 수 있다. - 기억
*/