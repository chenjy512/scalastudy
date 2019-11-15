package com.cjy.chapter12

/**
  * 守卫：if条件范围使用
  */
object T2_matchIf {
  def main(args: Array[String]): Unit = {
    for (c <- "+-3!") {
      var sign = 0
      var digit = 0

      c match {
        case '+' => sign = 1
        case '-' => sign = -1
        case _ if c.toString.equals("3") => digit = 3
        case _ if (c > 110 && c < 120) => println("110<c<120")
        case _ => sign = 2
      }
//      println(c + " " + sign + " " + digit)

      /**
        * + 1 0
        *- -1 0
        * 3 0 3
        * ! 2 0
        */


    }


    val list = List("技术速度",
      "运用机车台日数",
      "机车沿线公里",
      "本务机车公里",
      "不包单机总重吨公里",
      "包单机总重吨公里")
    val name ="G2CB"
    var tt="insert into `tsbds`.`t_dic_indicatorlibrary` (`gid`, `code`, `name`, `pym`, `measurementunit`, `indicator_class`, `generation_mode`, `indicator_length`, `tjjd`, `state`,operator) values (substr(UUID(),1,32), 'YJ1001', '货物运费收入', 'YJ1001', '17', '2303', '2', '5', 'D', '0','admin')"
    for (num <- 1 to 6){

      if(num <10){
        val str1:String="insert into `tsbds`.`t_dic_indicatorlibrary` (`gid`, `code`, `name`, `pym`, `measurementunit`, `indicator_class`, `generation_mode`, `indicator_length`, `tjjd`, `state`,operator) values (substr(UUID(),1,32), '"+name+"00"+num+"', '"+list(num-1)+"', '"+name+"00"+num+"', '17', '2303', '2', '5', 'D', '0','admin');"
        println(str1)
      }else{
        val str2:String="insert into `tsbds`.`t_dic_indicatorlibrary` (`gid`, `code`, `name`, `pym`, `measurementunit`, `indicator_class`, `generation_mode`, `indicator_length`, `tjjd`, `state`,operator) values (substr(UUID(),1,32), '"+name+"0"+num+"', '"+list(num-1)+"', '"+name+"0"+num+"', '17', '2303', '2', '5', 'D', '0','admin');"
        println(str2)
      }
    }
  }
}
