import axios from 'axios'

export const noticeListDB = (params) => {
  return new Promise((resolve, reject) => {
    try{
      const response = axios({
        method: 'get',
        url: process.env.REACT_APP_TOMCAT_IP + "notice/jsonNoticeList.do",
        params: params,
      });
      resolve(response) // 성공했을 때
    } 
    catch(error){
      reject(error) // 실패했을 때
    } //// end of try=catch
  });
}