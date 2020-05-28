import scala.util.matching.Regex
import java.util.HashSet
object test {
  def main(args: Array[String]): Unit = {
    val regex :Regex = "([A-Z]|\\p{Lu})([a-z]|\\p{L})*(( |\\-)([A-Z]|\\p{Lu})([a-z]|\\p{L})*)*".r
    val str = "Lịch sử của nước Nga bắt đầu từ lịch sử Đông-Slav. Nhà nước Đông Slav đầu tiên, nước Nga Kiev, đã chấp nhận việc du nhập Ki-tô giáo từ Đế quốc Đông La Mã vào năm 988 [32] khởi đầu sự tổng hòa các nền văn hoá Đông La Mã và Slav lập ra văn hoá Nga trong một nghìn năm tiếp theo.[33] Nước Nga Kiev nhanh chóng tan rã không còn là một Nhà nước nữa, cuối cùng chịu đầu hàng quân xâm lược Mông Cổ trong những năm 1230. Trong thời gian này, một số lãnh đạo địa phương, đặc biệt là xứ Novgorod và xứ Pskov, đã chiến đấu để thừa kế di sản văn hoá và chính trị của nước Nga Kiev.\n\nSau thế kỷ XIII, Moskva dần trở thành trung tâm văn hoá. Tới thế kỷ XVIII, Đại công quốc Moskva đã trở thành Đế quốc Nga rộng lớn, trải dài từ Ba Lan về phía đông tới Thái Bình Dương. Sự mở rộng về phía tây càng khiến nước Nga nhận thức được sự khác biệt của họ với đa phần còn lại của châu Âu và phá vỡ sự cô lập từng xảy ra ở những giai đoạn đầu mở rộng. Thời này có Nga hoàng Pyotr Đại Đế xóa bỏ một nước Nga lạc hậu, nửa Á Đông, tiến hành sự nghiệp lớn lao đổi mới đất nước.[34][35] Các vị Nữ hoàng Anna, Elizaveta Petrovna và Ekaterina II đều lên ngôi với những cuộc đảo chính do Ngự Lâm quân hỗ trợ.[36] Với chính sách bành trướng, phát triển thực lực của đất nước, triều đình Nga hoàng đã phá bỏ mối đe dọa từng có từ Vương quốc Thụy Điển và Đế quốc Thổ Nhĩ Kỳ Ottoman. Các triều đại nối tiếp nhau trong thế kỷ XIX đã đối phó với những áp lực đó bằng sự kết hợp giữa các cuộc cải cách miễn cưỡng và trấn áp. Chế độ nông nô Nga đã bị bãi bỏ năm 1861, nhưng sự huỷ bỏ này thực sự chỉ gây thêm phiền toái cho người nông dân và càng khiến áp lực cách mạng tăng cao. Trong khoảng thời gian từ khi chế độ nông nô bị huỷ bỏ tới khi bắt đầu Chiến tranh thế giới lần thứ nhất năm 1914, các cuộc cải cách Stolypin, hiến pháp 1906 và Duma quốc gia đã mang lại những thay đổi đáng kể cho nền kinh tế và chính trị Nga,[37] nhưng các hoàng đế Nga vẫn không muốn rời bỏ quyền lực tuyệt đối, hay chia sẻ quyền lực.[38]\n\nCách mạng Nga năm 1917 được khởi phát từ một sự tổng hợp các yếu tố tan rã kinh tế, tình trạng kiệt quệ do chiến tranh, và sự bất bình với hệ thống chính phủ chuyên quyền, và lần đầu tiên một liên minh giữa những người tự do và xã hội chủ nghĩa ôn hoà lên nắm quyền lực, nhưng các chính sách sai lầm của họ đã khiến những người Cộng sản Bolshevik chiếm quyền lực vào ngày 25 tháng 10 (lịch Julius, tức ngày 7 tháng 11 theo lịch Gregory). Từ năm 1922 tới năm 1991, lịch sử Nga chủ yếu là Lịch sử Liên Xô, một nhà nước hoàn toàn dựa trên ý thức hệ gồm các quốc gia láng giềng của Đế quốc Nga trước Hòa ước Brest-Litovsk. Tuy nhiên, việc tiếp cận cách thức xây dựng chủ nghĩa xã hội khác nhau trong từng thời điểm trong lịch sử Liên Xô, từ nền kinh tế pha trộn và xã hội và văn hoá đa dạng hồi thập niên 1920 tới nền kinh tế chỉ huy và trấn áp thời Stalin tới \"thời kỳ trì trệ\" thập niên 1980. Từ những năm đầu tiên, chính phủ Liên Xô đã dựa trên nền tảng độc đảng của những người Cộng sản, như những người Bolshevik tự gọi mình, từ tháng 3 năm 1918.[39] Tuy nhiên, tới cuối thập niên 1980, khi sự yếu kém của các cơ cấu kinh tế và chính trị đã trở nên gay gắt, các lãnh đạo cộng sản đã tiến hành các cải cách lớn, dẫn tới sự sụp đổ của Liên bang Xô viết.[40]\n\nLịch sử Liên bang Nga khá ngắn, chỉ bắt đầu từ sự sụp đổ của Liên Xô năm 1991. Từ khi giành lại độc lập, nước Nga đã được công nhận là nhà nước thừa kế chính thức của Liên Xô trên bình diện quốc tế.[41] Tuy nhiên, nước Nga đã mất vị trí siêu cường của mình và đang phải đối mặt với những thách thức trong các nỗ lực thiết lập một hệ thống kinh tế và chính trị hậu Xô viết. Loại bỏ nền kinh tế kế hoạch tập trung và quyền sở hữu nhà nước thời kỳ Xô viết, nước Nga đang nỗ lực xây dựng một nền kinh tế mang các yếu tố của thị trường tư bản, với những hậu quả nhiều khi khá nặng nề. Thậm chí ngày nay nước Nga vẫn mang nhiều nét đặc trưng văn hoá và xã hội thời kỳ Sa Hoàng và Liên Xô."

    val matching = regex.findAllIn(str)
//    println(matching.size)
    var location :Set[String] = Set()
    matching.foreach(x => location += x)
    location.foreach(f => println(f))

  }
}
