import React from 'react'
import { Map, MapMarker } from 'react-kakao-maps-sdk'

function MultMarker1210() {
  // 선언부
  const locations = [
    { title: 'KM타워', latlng: { lat: 37.476585, lng: 126.879956 } },
    { title: '가산디지털우체국', latlng: { lat: 37.477939, lng: 126.880616 } },
    { title: '롯데I캐슬', latlng: { lat: 37.4789, lng: 126.8791 } },
  ]

  return (
    <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
      <Map center={{ lat: 37.476946, lng: 126.880071 }}
        style={{
          maxWidth: "8000px", width: "100%", height: "560px"
          , border: "2px solid lightgray", borderRadius: "30px"
        }}
        level={3}
      >
        {locations.map((item, index) => (
          <MapMarker key={index} position={item.latlng}
            image={{
              src: "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png",
              size: { widht: 24, height: 35 }
            }}
          />
        ))}
        {/* <div style={{ color: "#000" }}>KOSMO</div> */}
      </Map>
    </div >
  )
}

export default MultMarker1210