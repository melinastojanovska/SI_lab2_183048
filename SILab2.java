import java.util.ArrayList;
import java.util.List;

class Angle {//1
    int degrees;//1
    int minutes;//1
    int seconds;//1

    public Angle(int degrees, int minutes, int seconds) {//1
        this.degrees = degrees;//1
        this.minutes = minutes;//1
        this.seconds = seconds;//1
    }//1

    public int getDegrees() {//1
        return degrees;//1
    }//1

    public int getMinutes() {//1
        return minutes;//1
    }//1

    public int getSeconds() {//1
        return seconds;//1
    }//1
};//1

public class SILab2 {//1

    public static List<Integer> function(List<Angle> angleList) {//1
        List<Integer> result = new ArrayList<>();//1

        for (int i = 0; i < angleList.size(); i++) {//2.1 2.2 2.3
            int deg = angleList.get(i).getDegrees();//3
            int min = angleList.get(i).getMinutes();//3
            int sec = angleList.get(i).getSeconds();//3
            if (deg >= 0 && deg < 360) {//3
                if (min < 0 || min > 59)//4
                    throw new RuntimeException("The minutes of the angle are not valid!");//5
                else {//6
                    if (sec < 0 || sec > 59)//7
                        throw new RuntimeException("The seconds of the angle are not valid");//7
                    else//8
                        result.add(deg * 3600 + min * 60 + sec);//8
                }
            }
            else if (deg == 360) {//9
                if (min == 0 && sec == 0)//10
                    result.add(deg * 3600 + min * 60 + sec);//11
                else//12
                    throw new RuntimeException("The angle is greater then the maximum");//12
            }
            else {//13
                throw new RuntimeException("The angle is smaller or greater then the minimum");//13
            }
        }//14
        return result;//15

    }//16
}
