class Solution {
    public List<String> letterCombinations(String digits) {

        String[] combinations = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index = 0;
        StringBuilder output = new StringBuilder();
        List<String> result = new ArrayList<>();
        solve(digits, index, combinations, output, result);
        return result;
    }

    private void solve(String digits, int index, String[] combinations, StringBuilder output, List<String> result) {

        if (index >= digits.length()) {
            result.add(output.toString());
            return;
        }

        int value = digits.charAt(index) - '0';
        String mappedString = combinations[value];

        for (int i = 0; i < mappedString.length(); i++) {
            output.append(mappedString.charAt(i));
            solve(digits, index + 1, combinations, output, result);
            //backtracking
            output.deleteCharAt(output.length() - 1);
        }

    }
}