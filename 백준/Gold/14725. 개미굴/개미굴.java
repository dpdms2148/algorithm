import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class TrieNode {
        Map<String, TrieNode> childNode = new HashMap<>();

        //Trie 저장
        public void insert(String strs) {
            TrieNode trieNode = this;
            String[] str = strs.split(",");
            for(String s : str){
                trieNode.childNode.putIfAbsent(s, new TrieNode());
                trieNode = trieNode.childNode.get(s);
            }
        }

        //Trie 출력
        public void print(TrieNode trie, int depth) {
            TrieNode trieNode = trie;
            if(trieNode.childNode != null){
                List<String> list = new ArrayList<>(trieNode.childNode.keySet());
                //사전순 정렬
                Collections.sort(list);
                for(String s : list){
                    for(int i=0; i<depth; i++){
                        System.out.print("--");
                    }
                    System.out.println(s);
                    print(trieNode.childNode.get(s), depth+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TrieNode trie = new TrieNode();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < K; j++) {
                sb.append(input[j + 1]).append(",");
            }
            trie.insert(sb.toString());

        }
        trie.print(trie, 0);
    }
}