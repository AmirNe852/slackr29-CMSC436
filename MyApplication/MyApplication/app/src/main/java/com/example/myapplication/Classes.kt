package com.example.myapplication

import com.google.firebase.firestore.QueryDocumentSnapshot

class Classes {

    var classId = String()
    var className = String()
    var university = String()
    var groupSize = GroupSize.TWO
    var schoolDepartment = String()
    var classSection = String()
    var numStudents = 0

    enum class GroupSize{
        TWO, THREE, FOUR, FIVEORMORE
    }


   internal constructor(className: String, university: String, groupSize: GroupSize, schoolDepartment: String, classSection :String, numStudents: Int)
   {
       this.className = className
       this.university = university
       this.groupSize = groupSize
       this.schoolDepartment = schoolDepartment
       this.classSection = classSection
       this.numStudents = numStudents
   }

    override fun toString(): String {
        return className+university+schoolDepartment
    }





}