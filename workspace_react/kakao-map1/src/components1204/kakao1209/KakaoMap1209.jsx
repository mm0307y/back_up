import React from 'react'
import { Map, MapMarker } from 'react-kakao-maps-sdk'


function KakaoMap1209() {
  return (
    <div style={{ display: "flex", flexDirection: "column", alignItems: "center"}}>
      <Map
        center={{ lat: 37.476946, lng: 126.880071 }}
        style={{
          maxWidth: "8000px", width: "100%", height: "560px"
          , border: "2px solid lightgray", borderRadius: "30px"
        }}
        level={3}
      >
        <MapMarker position={{ lat: 37.476946, lng: 126.880071 }}>
          <div style={{ color: "#000" }}>KOSMO</div>
        </MapMarker>
      </Map>
    </div>
  )
}

export default KakaoMap1209