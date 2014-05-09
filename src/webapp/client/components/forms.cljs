(ns webapp.client.components.forms
  (:require
   [goog.net.cookies :as cookie]
   [om.core          :as om :include-macros true]
   [om.dom           :as dom :include-macros true]
   [cljs.core.async  :refer [put! chan <! pub timeout]]
   [om-sync.core     :as async]
   [clojure.data     :as data]
   [clojure.string   :as string]
   [ankha.core       :as ankha])

  (:use
   [webapp.framework.client.coreclient      :only  [log remote]]
   [webapp.framework.client.system-globals  :only  [app-state   playback-app-state
                                                    playback-controls-state]]
   )
  (:use-macros
   [webapp.framework.client.neo4j      :only  [neo4j]]
   )
  (:require-macros
   [cljs.core.async.macros :refer [go]]))







(defn handle-change [app field e owner]
  (om/update! app [field] (.. e -target -value))
  ;(log (.. e -target -value))
  )











(defn request-form [{:keys [request data]} owner]
  (reify

    ;---------------------------------------------------------
    om/IRender
    (render
     [this]
     (dom/div
      nil
      (dom/div #js {:style #js {:padding-top "40px"}} " You ")

      (dom/div #js {:className "input-group"}

               (dom/span
                #js {:className "input-group-addon"}
                "Your full name")
               (dom/input
                #js {:type        "text"
                     :className   "form-control"
                     :placeholder "John Smith"
                     :value       (-> request :from-full-name)
                     :onChange    #(handle-change request :from-full-name % owner)
                     }))

      (dom/div #js {:className "input-group"}

               (dom/span
                #js {:className "input-group-addon"}
                "Your company email")
               (dom/input
                #js {:type "text"
                     :className "form-control"
                     :value       (-> request :email-from)
                     :onChange    #(handle-change request :emai-from % owner)
                     :placeholder "john@microsoft.com"}))

      (dom/div #js {:style #js {:padding-top "40px"}} " Them ")
      (dom/div #js {:className "input-group"}

               (dom/span
                #js {:className "input-group-addon"}
                "Their full name")
               (dom/input
                #js {:type "text"
                     :className "form-control"
                     :value       (-> request :to-full-name)
                     :onChange    #(handle-change request :to-full-name % owner)
                     :placeholder "Pete Austin"}))
      (dom/div
       #js {:className "input-group"}

       (dom/span
        #js {:className "input-group-addon"}
        "Their email")
       (dom/input
        #js {:type "text"
             :className "form-control"
             :value       (-> request :email-to)
             :onChange    #(do
                             (handle-change request :emai-to % owner)
                             (om/update! request [ :email-from] "zoso")
                             )
             :placeholder "pete@ibm.com"}))



      (dom/div
       #js {:style
            #js {:padding-top "40px"}}
       "The expertise your company has you want them to endorse ")


      (dom/div
       #js {:className "input-group"}

       (dom/span #js {:className "input-group-addon"}
                 "Skill your company has")
       (dom/input #js {:type        "text"
                       :className   "form-control"
                       :placeholder "marketing"}))
      ))
    ;---------------------------------------------------------

))



