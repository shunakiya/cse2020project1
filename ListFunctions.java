public class ListFunctions {

    /**
     * Return true if the list is empty.
     *
     * Examples:
     *
     * * isEmpty(makeList()) should return true
     * * isEmpty(makeList(0)) should return false
     *
     * @param list The list.
     * @return True if the list is empty; false otherwise.
     */
    public static boolean isEmpty(ListNode list) {
        return list == null;
    }

    /**
     * Get the number of elements in the list.
     *
     * Examples:
     *
     * * size(makeList()) should return 0
     * * size(makeList(0, 1)) should return 2
     *
     * @param list The list.
     * @return The size of the list.
     */
    public static int size(ListNode list) {
        if(list == null) {
        	return 0;
        }
        return 1 + size(list);
    }

    /**
     * Get the element at the index.
     *
     * The index is assumed to be in range.
     *
     * Examples:
     *
     * * get(makeList(0, 1, 4, 9), 2) should return 4
     *
     * @param list The list.
     * @param index The index of the desired element.
     * @return The element at the index.
     */
    public static int get(ListNode list, int index) {
        if (list == null) {
        	return (Integer) null;
        }
        
        if (index == 0) {
        	return (int) list.getFirst();
        }
        return get(list.getRest(), index - 1);
    }

    /**
     * Get the index of the first occurrence of the element.
     *
     * Examples:
     *
     * * indexOf(makeList(0, 3, 3, 4), 3) should return 1
     *
     * @param list The list
     * @param element The element.
     * @return The index of the first occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int indexOf(ListNode list, int element) {        
        return list.indexOf(element);
    }

    /**
     * Get the index of the last occurrence of the element.
     *
     * Examples:
     *
     * * lastIndexOf(makeList(0, 3, 3, 4), 3) should return 2
     *
     * @param list The list
     * @param element The element.
     * @return The index of the last occurrence element, or -1 if it is not in
     *   the list.
     */
    public static int lastIndexOf(ListNode list, int element) {
        return list.lastIndexOf(element);
    }

    /**
     * Return true if the two lists are the same.
     *
     * Examples:
     *
     * * equals(makeList(1, 2), makeList(1, 2)) should return true
     * * equals(makeList(1, 2), makeList(1, 1)) should return false
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return True if the lists are equal; false otherwise.
     */
    public static boolean equals(ListNode list1, ListNode list2) {
        if (list1.equals(list2) == true) {
        	return true;
        } else {
        	return false;
        }
    }

    /**
     * Create a new, reversed list.
     *
     * Examples:
     *
     * * reverse(makeList(1, 2, 3)) should be equivalent to makeList(3, 2, 1)
     *
     * @param list The list to reverse.
     * @return A new list that is reversed of the argument.
     */
    public static ListNode reverse(ListNode list) {
        if(list == null){
            return null;
        }

        if(list.next == null){
            return list;
        }

        ListNode nextElement = list.next;

        list.next = null;

        ListNode reverseIt = reverse(nextElement);

        nextElement.next = list;

        return reverseIt;
    }

    /**
     * Get the first n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * headList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(1, 2)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The head list of the specified size.
     */
    public static ListNode headList(ListNode list, int n) {
        return headListHelp(list,  n, new ListNode(), 0);
    }

    private static ListNode headListHelp(ListNode list, int n, ListNode newList, int index){
        if(n == 0 || index == list.size()){
            return newList;
        }
        newList.add(newList.get(index));
        return headListHelp(list, n - 1, newList, index + 1);
    }

    /**
     * Get the last n elements of a list.
     *
     * n is assumed to between 0 and the size of the list, inclusive.
     *
     * Examples:
     *
     * * tailList(makeList(1, 2, 3, 4), 2) should be equivalent to
     *   makeList(3, 4)
     *
     * @param list The list.
     * @param n The number of elements to get.
     * @return The tail list of the specified size.
     */
    public static ListNode tailList(ListNode list, int n) {
        return tailListHelp(list, n, new ListNode(), 0);
    }

    private static ListNode tailListHelp(ListNode list, int n, ListNode newList, int index){
        int size = list.size();

        if (n == 0 || index == size){
            ListNode reverseNewList = list.reverse();
            return newList;
        }

        newList.add(list.get(size - 1 - index));
        return tailListHelp(list, n - 1, index+1);
    }

    /**
     * Get the slice of the list between the start and end indices.
     *
     * start and end are assumed to be between 0 and the size of
     * the list, inclusive, and that start <= end.
     *
     * Examples:
     *
     * * subList(makeList(1, 2, 3, 4), 1, 3) should be equivalent to
     *   makeList(2, 3)
     *
     * @param list The list.
     * @param start The first index to include in the slice.
     * @param end The first index to exclude from the slice.
     * @return The slice of the list between the start and end indices.
     */
    public static ListNode subList(ListNode list, int start, int end) {
        return list.sublist(start - 1, end);
    }

    /**
     * Add an element at the end of the list.
     *
     * * add(makeList(1, 2), 3) should be equivalent to makeList(1, 2, 3)
     *
     * @param list The list.
     * @param element The element to add.
     * @return The list with the new element added.
     */
    public static ListNode add(ListNode list, int element) {
    	if(list == null) {
    		return new ListNode(element);
    	}
    	
    	list.next = add(list.next, element);
    	
    	ListNode newNode = new ListNode(element);
    	
    	return newNode;
    }

    /**
     * Add all of the second list to the end of the first list.
     *
     * * addAll(makeList(1, 2), makeList(3, 4)) should be equivalent to
     *   makeList(1, 2, 3, 4)
     *
     * @param list1 The first list.
     * @param list2 The second list.
     * @return A new list that combines the two lists.
     */
    public static ListNode addAll(ListNode list1, ListNode list2) {
        return list1.add(list2);
    }
}