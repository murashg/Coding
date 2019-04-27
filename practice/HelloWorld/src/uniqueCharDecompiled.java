import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;

@Metadata(
   mv = {1, 1, 15},
   bv = {1, 0, 3},
   k = 2,
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"findFirstUniqueChar", "", "input", "main", "", "HelloWorld"}
)
public final class UniqueCharKt {
   public static final void main() {
      String var0 = findFirstUniqueChar("abcda");
      boolean var1 = false;
      System.out.println(var0);
      var0 = findFirstUniqueChar("");
      var1 = false;
      System.out.println(var0);
      var0 = findFirstUniqueChar("aabbccdeeffghoisdf");
      var1 = false;
      System.out.println(var0);
      var0 = findFirstUniqueChar("aabbcc");
      var1 = false;
      System.out.println(var0);
   }

   // $FF: synthetic method
   public static void main(String[] var0) {
      main();
   }

   private static final String findFirstUniqueChar(String input) {
      CharSequence var1 = (CharSequence)input;
      boolean var2 = false;
      if (var1.length() == 0) {
         return "No Unique Chars";
      } else {
         var2 = false;
         Map map = (Map)(new LinkedHashMap());
         String var4 = input;
         int var5 = input.length();

         for(int var3 = 0; var3 < var5; ++var3) {
            char c = var4.charAt(var3);
            Character var10001 = c;
            Integer var10002 = (Integer)map.get(c);
            map.put(var10001, var10002 != null ? var10002 + 1 : 1);
         }

         Iterable var15 = (Iterable)map.entrySet();
         boolean var16 = false;
         boolean var17 = false;
         Iterator var6 = var15.iterator();

         Object var10000;
         while(true) {
            if (var6.hasNext()) {
               Object var7 = var6.next();
               Entry $dstr$_u24__u24$count = (Entry)var7;
               int var9 = false;
               boolean var11 = false;
               int count = ((Number)$dstr$_u24__u24$count.getValue()).intValue();
               if (count >= 2) {
                  continue;
               }

               var10000 = var7;
               break;
            }

            var10000 = null;
            break;
         }

         Entry var18 = (Entry)var10000;
         String var20;
         if ((Entry)var10000 != null) {
            Character var19 = (Character)var18.getKey();
            if (var19 != null) {
               var20 = String.valueOf(var19);
               if (var20 != null) {
                  return var20;
               }
            }
         }

         var20 = "No Unique Chars";
         return var20;
      }
   }
}
