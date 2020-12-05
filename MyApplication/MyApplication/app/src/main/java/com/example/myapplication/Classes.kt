package com.example.myapplication

import android.content.Intent

class Classes {

    var className = String()
    var university = String()
    var groupSize = GroupSize.TWO
    var schoolDepartment = String()
    var classSection = String()

    enum class GroupSize{
        TWO, THREE, FOUR, FIVEORMORE
    }


   internal constructor(className: String, university: String, groupSize: GroupSize, schoolDepartment: String, classSection :String)
   {
       this.className = className
       this.university = university
       this.groupSize = groupSize
       this.schoolDepartment = schoolDepartment
       this.classSection = classSection
   }

}