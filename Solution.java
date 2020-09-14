import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

public class Solution {
	private static Character getFirst(String input) {
		Map<Character, Integer>  map= new HashMap<>();
		for(int i = 0; i < input.length();i++) {
			char ch = input.charAt(i);
			map.put(ch,map.getOrDefault(ch, 0) + 1);
		}
		Character result = null;
		for(int i = 0; i < input.length();i++) {
			char ch = input.charAt(i);
			if(map.get(ch) == 1) {
				result = ch;
				break;
			}
		}
		PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			minHeap.offer(entry);
		}
		while(!minHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = minHeap.poll();
			for(int i = 0; i < entry.getValue();i++) {
				sb.append(entry.getKey());
			}
		}
		System.out.println(sb.toString());
		return result;
	}

    public static void main(String[] args) {
       String input = JOptionPane.showInputDialog(null, "Enter your word ere:");
       // System.out.println("Your input is: " + input);
       System.out.println(Solution.getFirst(input));
       
    }
}