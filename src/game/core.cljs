(ns game.core) 


(def render-width 500)
(def render-height 500)

(def scene-width 1000)
(def scene-height 1000)
(def aspect (/ render-width render-height))
(def near 1)
(def far 1000)

(def renderer (THREE.WebGLRenderer.))
(def camera (THREE/OrthographicCamera. 0  scene-width scene-height 0 -1000 1000 ))
(def scene (THREE/Scene.))
(.add scene camera)
(.set (.-position camera) 0 0 120)
(aset camera "aspect" aspect)
(.setSize renderer render-width render-height)


(def radius 50)
(def segments 16)
(def rings 16)

(def sphere (THREE.Mesh. 
              (THREE.SphereGeometry. radius segments rings)
              (THREE.MeshPhongMaterial. (clj->js { "color" 0xff0000}))))

(.set (.-position sphere) 500 500 0)
(.add scene sphere)
(def light (THREE.PointLight. 0xFFFF00))
(.set (.-position light) 500 500 300)
(.add scene light)

(.appendChild (.getElementById js/document "container") (.-domElement renderer))

(js/setInterval (fn [] (.render renderer scene camera)) 30)
