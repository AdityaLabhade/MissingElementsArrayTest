fun main() {
    val array1 = arrayOf("goat", "fish", "deer", "goat", "bear")
    val array2 = arrayOf("ant", "bear", "goat")
    val result =  MissingElementsArray<String>().solve(array1, array2)
    println(result)
}

class MissingElementsArray<T> {
    fun solve(arr1: Array<T>, arr2: Array<T>): ArrayList<T> {
        val missingNumbers =ArrayList<T>()
        val array1ElementsCount = HashMap<T, Int>()
        val array2ElementsCount = HashMap<T, Int>()
        arr1.sort()
        arr2.sort()

        for (element in arr1) {
            array1ElementsCount[element] = array1ElementsCount.getOrDefault(element, 0) + 1
        }

        for (element in arr2) {
            array2ElementsCount[element] = array2ElementsCount.getOrDefault(element, 0) + 1
        }

        for (entry in array2ElementsCount.entries) {
            if (entry.value != array1ElementsCount.getOrDefault(entry.key,0))
                missingNumbers.add(entry.key)
        }
        return missingNumbers
    }
}
