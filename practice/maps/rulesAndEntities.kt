//rule and entities

fun checkConflicts(List<Rule> rules, Set<String> allEntities){
    var conflicts = ""
    val allowMap = HashMap<Int, Rule>()
    val disallowMap = HashMap<Int, Rule>()
    //create allow and disallow maps
    for (r in rules) {
   		if (r.allow){
            if (!allowMap.containsKey(r.access)){
                allowMap.put(r.access, r.entities)
            }else{
                val allowEntities = r.getEntities()
                for (s in allowEntities){
                    if (!r.entities.contains()) r.entities.add(s)
                }
                allowMap.put(r.access, r.entities)
            }
        }else{
            if (!disallowMap.containsKey(r.access)){
                disallowMap.put(r.access, r.entities)
            }else{
                val disallowEntities = r.getEntities()
                for (s in disallowEntities){
                    if (!r.entities.contains()) r.entities.add(s)
                }
                disallowMap.put(r.access, r.entities)
            }
        }
    }
    for (k,v in allowMap){
        if (disallowMap.containsKey(k)){
            for (s in v) if (disallowMap.get(k).contains(s)){
                conflicts += "$k $disallowMap.set s"
            }
        }
    }
    println(conflicts)
}
