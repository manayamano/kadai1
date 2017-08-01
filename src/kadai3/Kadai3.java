package kadai3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Kadai3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//ファイル読み込み
//		System.out.println("アラビア数字を入力してください。");
//		Scanner scanner = new Scanner(System.in);
//		int num = scanner.nextInt();

		final String FILE_PATH="C:\\tmp\\test.txt";
		final String SEPARATOR="(\\s|\\.|,|;)";


		Map<String, Integer> map = new HashMap<>();

//		ファイル読み取り、単語を数える
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(FILE_PATH);
			br = new BufferedReader(fr);

			String line;
			while((line = br.readLine()) != null){
				line=line.toLowerCase(); //小文字
				String[] words = line.split(SEPARATOR);
				for (String word : words){
					if(!word.isEmpty()){
						if(map.containsKey(word)){
							int count = map.get(word)+1;
							map.put(word,  count);
						}else{
							map.put(word, 1);
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

//		System.out.println(map);


		//並べ替え
		List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(key);
        }
        Collections.sort(list, (o1, o2) -> {
            return - map.get(o1) + map.get(o2);
        });

		//表示
        for (String word : list) {
            int count = map.get(word);
            System.out.println(word + ":" + count);
        }


	}

}
