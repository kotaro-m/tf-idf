tf-idf
======================
tf-idfを行うプログラムです。
使用ライブラリとして"kuromoji.jar"を使用しています。

ダウンロードは"https://github.com/atilika/kuromoji/downloads" からお願いします。
 
使い方
------
tfidfクラスのtf_idfに解析したい文章をArrayListに全てaddした後、引数として渡してください。
returnはHashMapnにて、抽出した文章内の名詞とその名詞のtf_idfをつなぎ、それをArrayListにて文章ごとに配列化して返します。

returnされたものは順番がランダムになっているのでMain内のコメントアウトのどちらかを使ってソートすることをおすすめします。
