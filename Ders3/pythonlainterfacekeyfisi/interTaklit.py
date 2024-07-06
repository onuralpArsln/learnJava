
class TeacherBase:
    def silenceClass(self):
        raise Exception("not implemented yet")
    

class HsTeacher(TeacherBase):
    def represent(self):
        print("merabalarrr")

mahmut = HsTeacher()

print(mahmut)



mahmut.silenceClass()

