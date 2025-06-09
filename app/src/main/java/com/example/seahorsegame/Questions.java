package com.example.seahorsegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
    private static final List<Question> questions = new ArrayList<>();
    private static final Random random = new Random();

    static {
        questions.add(new Question(
                "1 + 1 = ?",
                new String[]{"2", "3", "4"},
                0
        ));
        questions.add(new Question(
                "Thủ đô của Việt Nam là gì?",
                new String[]{"Hà Nội", "TP.HCM", "Đà Nẵng"},
                0
        ));
        questions.add(new Question(
                "2 x 3 = ?",
                new String[]{"5", "6", "8"},
                1
        ));
        questions.add(new Question(
                "Ai là người đẹp trai nhất (Theo kết quả của TC Candler 2024)?",
                new String[]{"Henry Cavil" , "Christian Bale", "Tom Cruis"},
                1
        ));
        questions.add(new Question(
                "Thủ đô của nước Pháp là?",
                new String[]{"Berlin", "Paris", "Madrid"},
                1
        ));
        questions.add(new Question(
                "Solve: ∫x dx = ?",
                new String[]{"x^2/2 + C", "x + C", "1/x + C"},
                0
        ));
        questions.add(new Question(
                "Từ nào là danh từ?",
                new String[]{"Quickly", "Happiness", "Run"},
                1
        ));
        questions.add(new Question(
                "Đạo hàm của sin(x) là gì?",
                new String[]{"cos(x)", "-cos(x)", "-sin(x)"},
                0
        ));
        questions.add(new Question(
                "Đạo hàm của ln(x) là gì?",
                new String[]{"1/x", "ln(x)", "x"},
                0
        ));
        questions.add(new Question(
                "Which tense is this: 'I had eaten'?",
                new String[]{"Past Perfect", "Present Perfect", "Future Perfect"},
                0
        ));
        questions.add(new Question(
                "Giá trị của giới hạn lim(x→0) sin(x)/x là?",
                new String[]{"0", "1", "Không tồn tại"},
                1
        ));
        questions.add(new Question(
                "If A = {1,2,3}, how many subsets does A have?",
                new String[]{"6", "8", "9"},
                1
        ));
        questions.add(new Question(
                "Which one is a prime number?",
                new String[]{"4", "6", "7"},
                2
        ));
        questions.add(new Question(
                "Tập xác định của hàm số y = √(x-2) là?",
                new String[]{"x ≥ 2", "x > 2", "x ≤ 2"},
                0
        ));
        questions.add(new Question(
                "Kết quả của 3^2 × 2 là?",
                new String[]{"18", "12", "36"},
                0
        ));
        questions.add(new Question(
                "Câu nào dưới đy là câu bị động 'He writes a letter'",
                new String[]{"A letter was written", "A letter is written", "A letter wrote"},
                1
        ));
        questions.add(new Question(
                "Xác suất gieo một con xúc xắc được số chẵn là?",
                new String[]{"1/2", "1/3", "2/3"},
                0
        ));
        questions.add(new Question(
                "Hàm số nào là hàm số lẻ?",
                new String[]{"f(x) = x^3", "f(x) = x^2", "f(x) = x + 1"},
                0
        ));
        questions.add(new Question(
                "If f(x) = x^2, then f'(2) = ?",
                new String[]{"2", "4", "8"},
                0
        ));
        questions.add(new Question(
                "Ai là người phát hiện ra châu Mỹ vào năm 1492?",
                new String[]{"Christopher Columbus", "Marco Polo", "Vasco da Gama"},
                0
        ));

        questions.add(new Question(
                "Cuộc cách mạng Pháp bắt đầu vào năm nào?",
                new String[]{"1776", "1789", "1804"},
                1
        ));
        questions.add(new Question(
                "Thủ đô của Úc là gì?",
                new String[]{"Sydney", "Melbourne", "Canberra"},
                2
        ));

        questions.add(new Question(
                "Sông dài nhất thế giới là gì?",
                new String[]{"Sông Nile", "Sông Amazon", "Sông Yangtze"},
                1
        ));
        questions.add(new Question(
                "Số nhiều của danh từ 'child'?",
                new String[]{"childs", "children", "childes"},
                1
        ));

        questions.add(new Question(
                "Chọn từ ở thì quá khứ đơn của từ 'go':",
                new String[]{"goed", "goes", "went"},
                2
        ));
        questions.add(new Question(
                "Tích phân từ 0 đến 1 của hàm số f(x) = x^2 là bao nhiêu?",
                new String[]{"1/2", "1/3", "1/6"},
                1
        ));

        questions.add(new Question(
                "Phương trình nào sau đây có nghiệm kép?",
                new String[]{"x^2 - 4x + 4 = 0", "x^2 + 4x + 4 = 0", "x^2 - 4x - 4 = 0"},
                0
        ));

        questions.add(new Question(
                "Giá trị lớn nhất của hàm số f(x) = -x^2 + 4x - 3 trên đoạn [0, 3] là bao nhiêu?",
                new String[]{"1", "5", "4"},
                1
        ));
        questions.add(new Question(
                "Tác phẩm 'Truyện Kiều' của Nguyễn Du được viết bằng thể thơ nào?",
                new String[]{"Thơ lục bát", "Thơ thất ngôn bát cú", "Thơ song thất lục bát"},
                0
        ));

        questions.add(new Question(
                "Nhân vật Chí Phèo trong tác phẩm cùng tên của Nam Cao là hiện thân của điều gì?",
                new String[]{"Bi kịch tha hóa", "Sự thành công", "Cuộc sống giàu sang"},
                0
        ));

        questions.add(new Question(
                "Ai là tác giả của bài thơ 'Tây Tiến'?",
                new String[]{"Quang Dũng", "Tố Hữu", "Huy Cận"},
                0
        ));
        questions.add(new Question(
                "Ai là người lãnh đạo cuộc khởi nghĩa Lam Sơn?",
                new String[]{"Nguyễn Trãi", "Lê Lợi", "Quang Trung"},
                1
        ));

        questions.add(new Question(
                "Chiến thắng Bạch Đằng năm 938 do ai chỉ huy?",
                new String[]{"Ngô Quyền", "Lý Thường Kiệt", "Trần Hưng Đạo"},
                0
        ));

        questions.add(new Question(
                "Phong trào Cần Vương diễn ra vào thời kỳ nào?",
                new String[]{"Thời kỳ nhà Nguyễn", "Thời kỳ Pháp thuộc", "Thời kỳ Bắc thuộc"},
                1
        ));

        questions.add(new Question(
                "Hiệp định Paris về chấm dứt chiến tranh ở Việt Nam được ký vào năm nào?",
                new String[]{"1972", "1973", "1975"},
                1
        ));

        questions.add(new Question(
                "Ai là vị vua cuối cùng của triều Nguyễn?",
                new String[]{"Gia Long", "Bảo Đại", "Minh Mạng"},
                1
        ));



    }

    public static Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}

