import React, { useEffect, useState } from "react";
import styled from "styled-components";
import Header1211 from "../include1211/Header1211";
import Footer1211 from "../include1211/Footer1211";
import { logout, onAuthChange } from "../../service1212/authLogic1212";
import { useNavigate } from "react-router-dom";
import CardEditor1210 from "./CardEditor1210";
import Preview1210 from "./Preview1210";

const MarkerDiv = styled.div`
  width: 100%;
  height: 100%;
  max-width: 80rem;
  display: flex;
  flex-direction: column;
  background-color: makerWhite;
`;
const ContainerDiv = styled.div`
  display: flex;
  flex: 1; /* 중간에 여백을 가득채우도록 1을 준다 */
  min-height: 0;
`;

const Marker1210 = ({ FileInput, authLogic, cardLogic }) => {
  const [cards, setCards] = useState({});
  const navigate = useNavigate();
  const [userId, setUserId] = useState();
  //로그아웃 후에 저장소에 있는 네임카드 정보를 가져오는 코드가 필요하다.
  //useEffect도 훅이다. 업무별로 여러개를 만들 수 있다.
  //우리가 원하는 것은 Marker라는 컴포넌트가 마운트 되었을 때 또는 사용자의 아이디가
  //변경되었을 때 계속 동기화 되기를 원한다.
  //사용자 아이디가 있을 때만 우리가 정의한 carLogic에 있는 syncCards라는 함수를 호출한다.
  useEffect(() => {
    console.log("syncCards effect");
    if (!userId) {
      return;
    }
    const stopSync = cardLogic.syncCards(userId, (cards) => {
      setCards(cards);
    });
    //stopSync함수를 리턴하게 되면 cardLogic.js의 syncCards함수의 off()함수가
    //호출되서 그냥 꺼집니다.
    return () => stopSync();
  }, [userId, cardLogic]); //두번째 파라미터는 의존성 배열임

  useEffect(() => {
    console.log("effect");
    const loginCheck = async () => {
      const user = await onAuthChange(authLogic.auth);
      if (user) {
        setUserId(user.uid);
      } else {
        navigate("/");
      }
    }; //end of loginCheck
    loginCheck();
  }); //일부러 의존배열은 적지 않았다. 모든 변화에 상태를 추적해야 하니까....
  const onLogout = async () => {
    console.log("onLogout");
    await logout(authLogic.auth);
    navigate("/");
  };

  const createOrUpdateCard = (card) => {
    console.log(card); // 단위테스트: 전달받은 것 호출해 보기
    // 이전에 상태값을 받아서 새로운 값을 하는 이런 콜백함수로도 이용이 가능합니다
    // 새로 업데이트 되는 card를 변경해 주고 리턴은 업데이트된 아이를 리턴해줘야겠죠
    setCards((cards) => {
      console.log(cards); //추가되기 전 cards정보
      const updated = { ...cards };
      console.log(updated);
      // 어차피 여기서 id가 오브젝트에 없었다면 새로운 것이 추가가 되어져요
      // 그래서 addCard는 필요가 없어요
      updated[card.id] = card;
      return updated;
    });
    //Realtime Database에 저장하기 추가
    console.log(`${userId}, ${card}`);
    cardLogic.saveCard(userId, card);
  };
  const deleteCard = (card) => {
    console.log(card); // 단위테스트: 전달받은 것 호출해 보기
    setCards((cards) => {
      const updated = { ...cards };
      delete updated[card.id];
      return updated;
    });
    console.log(`삭제 카드 card.id ${card.id}`);
    cardLogic.removeCard(userId, card);
  };
  return (
    <MarkerDiv>
      <Header1211 onLogout={onLogout} />
      <ContainerDiv>
        <CardEditor1210
          FileInput={FileInput}
          cards={cards}
          addCard={createOrUpdateCard}
          updateCard={createOrUpdateCard}
          deleteCard={deleteCard}
        />
        <Preview1210 cards={cards} />
      </ContainerDiv>
      <Footer1211 />
    </MarkerDiv>
  );
};

export default Marker1210;
