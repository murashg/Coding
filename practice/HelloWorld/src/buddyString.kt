class Solution{

    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length) return false
        val map = mutableMapOf<Char, Int>()
        var mapDone = false
        var c = 0
        val l = mutableListOf<Pair<Char,Char>>()
        for ((i, a) in A.withIndex())
            if (a != B[i]) if (c == 2) return false else {
                c++
                l.add(a to B[i])
            }else if(!mapDone){
                map[a] = map[a]?.plus(1) ?: 1
                if (map[a] == 2) mapDone = true
            }
        if (mapDone && A == B) return true
        return c == 2 &&
                l[0].first == l[1].second && l[1].first == l[0].second
    }
}
    fun main(){
        val solution = Solution()
       // print(solution.buddyStrings())
    }
