import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) { 
        // 오프닝 건너뛰기
        int iPos = timeToInt(pos);
        int iStart = timeToInt(op_start);
        int iEnd = timeToInt(op_end);
        int iLen = timeToInt(video_len);
        iPos = skipOpening(iPos, iStart, iEnd);
        
        // command 처리
        for (String command : commands) {
            switch (command) {
                case "prev":
                    if (iPos < 10) {
                        iPos = 0;
                    } else {
                        iPos -= 10;
                    }
                    break;
                case "next":
                    if (iPos > iLen - 10) {
                        iPos = iLen;
                    } else {
                        iPos += 10;
                    }
                    break;
            }
            iPos = skipOpening(iPos, iStart, iEnd);
        }
        
        StringBuilder sb = new StringBuilder();
        int min = iPos / 60;
        int sec = iPos % 60;
        String sMin = String.format("%2d", min).replace(" ", "0");
        String sSec = String.format("%2d", sec).replace(" ", "0");
        sb.append(sMin).append(':').append(sSec);
        return sb.toString();
    }
    
    private static int timeToInt(String time) {
        String[] sTime = time.split(":");
        int timeNum = Integer.parseInt(sTime[0]) * 60 + Integer.parseInt(sTime[1]);
        return timeNum;
    }
    
    private static int skipOpening(int pos, int start, int end) {
        if (pos >= start && pos <= end) {
            pos = end;
        }
        return pos;
    }
}