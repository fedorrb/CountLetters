package letters.count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class LetterFrequency {
	private HashMap<Character, Integer> unsortedMap = new HashMap<>();
	private LinkedList<Map.Entry<Character, Integer>> list = new LinkedList<>();

	private void loadTextFromFile(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			for (;;) {
				int i = br.read();
				if (i < 0)
					break;
				if (i < 65 || i > 122 || (i > 90 && i < 97))
					continue;
				char ch = (char) i;
				if (unsortedMap.containsKey(ch)) {
					unsortedMap.put(ch, unsortedMap.get(ch) + 1);
				} else {
					unsortedMap.put(ch, 1);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void calcLetterFrequency(String path) {
		loadTextFromFile(path);
		sortByComparator(unsortedMap);
	}

	private void sortByComparator(Map<Character, Integer> unsortMap) {
		// Convert Map to List
		list = new LinkedList<Map.Entry<Character, Integer>>(unsortMap.entrySet());
		// Sort list by value
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
	}

	public void printLetters() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Entry<Character, Integer> entry : list){
			sb.append("Key : " + entry.getKey() + " Value : " + entry.getValue() + "\n");
		}
		return sb.toString();
	}
	
}
