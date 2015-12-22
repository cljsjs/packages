(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.0"  :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "2.2.7")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom  {:project     'cljsjs/echarts
       :version     +version+
       :description "A declarative JavaScript chart library built on HTML Canvas"
       :url         "http://ecomfe.github.io/echarts/index-en.html"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"MIT" "https://github.com/ecomfe/echarts/blob/master/LICENSE.txt"}})

(deftask package []
  (comp
    (download :url (str "https://github.com/ecomfe/echarts/archive/" +lib-version+ ".zip")
              :checksum "5910dbce125fe826f495c9715f4eab4c"
              :unzip true)
    (sift :move {#"^echarts-([\d\.]*)/build/source/echarts-all\.js$" "cljsjs/echarts/development/echarts.inc.js"
                 #"^echarts-([\d\.]*)/build/dist/echarts-all\.js$" "cljsjs/echarts/production/echarts.min.inc.js"})
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"辅助线开关" :value "Line mark")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"辅助线开关" :value "Line mark")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"删除辅助线" :value "Delete line mark")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"删除辅助线" :value "Delete line mark")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"清空辅助线" :value "Clear marks")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"清空辅助线" :value "Clear marks")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"区域缩放后退" :value "Reset zoom")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"区域缩放后退" :value "Reset zoom")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"区域缩放" :value "Zoom")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"区域缩放" :value "Zoom")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"数据视图" :value "Data view")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"数据视图" :value "Data view")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"关闭" :value "Close")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"关闭" :value "Close")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"刷新" :value "Refresh")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"刷新" :value "Refresh")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"折线图切换" :value "Switch to line chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"折线图切换" :value "Switch to line chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"柱形图切换" :value "Switch to bar chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"柱形图切换" :value "Switch to bar chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"堆积" :value "Switch to stack chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"堆积" :value "Switch to stack chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"平铺" :value "Switch to tiled chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"平铺" :value "Switch to tiled chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"力导向布局图切换" :value "Switch to force directed layout")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"力导向布局图切换" :value "Switch to force directed layout")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"和弦图切换" :value "Switch to chord chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"和弦图切换" :value "Switch to chord chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"饼图切换" :value "Switch to pie chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"饼图切换" :value "Switch to pie chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"漏斗图切换" :value "Switch to funnel chart")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"漏斗图切换" :value "Switch to funnel chart")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"还原" :value "Restore")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"还原" :value "Restore")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"保存为图片" :value "Save as image")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"保存为图片" :value "Save as image")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"点击保存" :value "Click to save")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"点击保存" :value "Click to save")
    (replace-content :in "cljsjs/echarts/production/echarts.min.inc.js" :match #"暂无数据" :value "No data yet")
    (replace-content :in "cljsjs/echarts/development/echarts.inc.js" :match #"暂无数据":value "No data yet")
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.echarts")))
