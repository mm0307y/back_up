import axios from "axios";

export const noticeListDB = (params) => {
  //파라미터 값을 출력해 보기 - SELECT * FROM notice WHERE n_content like '%'||?||'%'
  console.log(params);
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "get",
        url: process.env.REACT_APP_TOMCAT_IP + "api",
        params: params,
      });
      resolve(response); //성공했을 때
    } catch (error) {
      reject(error); //실패했을 때
    } //end of try..catch
  });
};
