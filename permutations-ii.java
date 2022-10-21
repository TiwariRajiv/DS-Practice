class Solution {
    
    Set<List<Integer>> result = new HashSet<>();
    
    private void permuteUniqueUtil(List<Integer> list, int index) {
        if (index == list.size()) {
            List<Integer> l = new ArrayList<>(list);
            result.add(l);
            return;
        }
        for (int i=index; i<list.size(); i++) {
            swapIndices(list, i, index);
            permuteUniqueUtil(list, index+1);
            swapIndices(list, i, index);
        }
    }
    
    private void swapIndices(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        permuteUniqueUtil(list, 0);
        return new ArrayList<>(result);
    }
}
