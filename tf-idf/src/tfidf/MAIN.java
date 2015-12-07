package tfidf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MAIN {
	public static void main(String[] args) throws IOException{
		ArrayList<String> article_list = new ArrayList<String>();
		int count=0;
		article_list.add("　2015年のドラフト会議が終了。高橋純平、オコエ瑠偉、小笠原慎之介、熊原健人と注目選手が次々と指名されていった。　一方で指名されなかった選手もいる。東海大菅生高では投手を務め、U-18ワールドカップでは内野手と外野手を務めた勝俣翔貴は指名されず。U−18ワールドカップでは打率.556で首位打者、12打点で打点王を獲得。木製バットを苦にせず結果を残していた。 　また大学生では、秋のリーグ戦で5本塁打を記録している慶応大の谷田成吾が指名漏れ。阪神から1位指名を受けた明治大の高山俊、日本ハムから6位指名を受けた慶応大の横尾俊建とともに、日大三時代に全国制覇を経験した法政大の畔上翔は、秋のリーグ戦でリーグ2位の打率.395と好調を維持していたがプロ入りが叶わなかった。　その他、大学ジャパンの北村祥治、藤岡裕大、立命館大学の山足達也も指名漏れとなっている。【指名漏れとなった主な選手】 勝俣翔貴（東海大菅生高） 谷田成吾（慶応大） 畔上翔（法政大） 北村祥治（亜細亜大） 藤岡裕大（亜細亜大） 山足達也（立命館大）");
		article_list.add("　２１日、新たに野球賭博への関与が発覚した松本竜也投手（２２）は、巨人でも指折りの“問題児”だった。２０１１年ドラフト１位で香川・英明高から巨人に入団。実はその際にも“トラブル”があった。高校側や巨人が把握していない個人ブログ上で、当時交際していた彼女との度を越えたラブラブ生活ぶりを公開していたことが発覚。指名後に球団があわてて削除に動いた。 　入団後は１９３センチの長身を生かした本格派の大型左腕として期待されたが、伸び悩んで４年目の今季も一軍登板はなし。それでも気の弱い先輩に荷物を運ばせるなど、高卒４年目とは思えぬ態度のデカさが有名で、ひと回りも年の離れた先輩ナインやコーチからは、あきれ半分で「松本さん」と“さん付け”で呼ばれていた。 　またキャンプ地の宮崎市内では、たばこをくわえながらパチンコ台に向かう姿がたびたび目撃されるなど、ギャンブル好きはチーム内でも有名だった。");
		article_list.add("　アナフィラキシーを起こしたと２０日のブログで明かしたＳＤＮ４８の元メンバーでタレントの大堀恵が、２１日、ブログを更新。心配をかけたことを謝罪するとともに、夫婦、娘（１）と夫と３人でアレルギーテストを受けることを記した。　大堀は２０日に更新したブログで、「実は一昨日の夜中に食物アレルギーが原因でアナフィラキシーを起こしてしまい夜間の救急病院へ駆け込みました」と告白。「突然体が強烈に痒くなり手が真っ赤に腫れ上がり、のどが締め付けられる感じで呼吸困難になってしまいました」と振り返った。 　最初は強い喘息のような苦しさだったという。もともと喘息もちだったが、ここ１５、６年は発作が出ておらず、「ほぼ完治状態」だっただけに、何が原因か分からず、「本当に怖かったです。。。」と明かしていた。手は腫れ上がり、血圧も低下したという。 　医師からは「青魚」が原因ではないか？と言われたそうで、夕ご飯で食べた秋刀魚が原因かも、と自己分析していた。これまで青魚でアレルギー反応が出たことはなかったという。 　２１日のブログでは「みなさん、ご心配おかけして申し訳ございません」と騒動になったことを謝罪。今週中にもアレルギー反応テストを家族で受けることを明かした。夫婦ともにアレルギー持ちという。 　▼アナフィラキシーショックとは 　アレルギーの一種で、死に至ることもある危険な状態。呼吸困難、むくみやじんましんなどの症状が一気に現れる。原因物質と接触すると早い場合には１分以内、通常でも１０分以内で症状が起こる。進行が早く、発症後２時間以内に亡くなることもある。 　原因物質は食品や、薬などさまざま。全身がショック状態となる。");

		ArrayList<HashMap<String,Double>> b = new ArrayList<HashMap<String,Double>>(tfidf.tf_idf(article_list));

		for(int i = 0; i <b.size(); i++){
			System.out.println("文章" + i);
			List<Entry<String, Double>> entries = new ArrayList<Entry<String, Double>>(b.get(i).entrySet());

			//↓tfidfの結果を昇順に並び替え
			Collections.sort(entries, new Comparator<Entry<String, Double>>() {
			    //比較関数
			    @Override
			    public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
			        return o1.getValue().compareTo(o2.getValue());
			    }
			});

			//↓tfidfの結果を降順に並び替え
			/*Collections.sort(entries, new Comparator<Entry<String, Double>>() {
			    //比較関数
			    @Override
			    public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
			        return o2.getValue().compareTo(o1.getValue());
			    }
			});*/

			for(Entry<String,Double> entry : entries){
				if(count == 20)
					break;
				System.out.println(entry.getKey() + ":" + entry.getValue());
				count++;
			}
			count = 0;
		}
	}
}
