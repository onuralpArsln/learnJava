AVL ağaçları, dengeli ikili arama ağaçlarıdır. Bu tür bir ağaçta her düğümün, sol ve sağ alt ağaçlarının yüksekliği arasındaki fark en fazla 1'dir. Yani, her düğümün dengelilik faktörü (balance factor) -1, 0 veya 1 olmalıdır. Eğer bu fark 1'den büyükse, ağaç dengesizleşir ve yeniden dengelemek için dönüşüm işlemleri (rotasyon) yapılır.



# Rotasyonlar 

## LL (Sol-Sol) Rotasyonu

rotasyon öncesi

    30
   /
  20
 /
10

rotasyon sonrası

    20
   /  \
  10   30


## LR (Sol-Sağ) Rotasyonu

Rotasyondan önce

    30
   /
  10
   \
   20

10 ve 20 arası bir rotasyon yapılması

    30
   /
  20
 /
10

Ardından dengeyi sağlayan rotasyon 
    20
   /  \
  10   30


  ## RR (Sağ-Sağ) Rotasyonu

    10
     \
     20
       \
       30


    20
   /  \
  10   30

  ## RL (Sağ-Sol) Rotasyonu

    10
    \
    30
   /
  20

önce 30 20 arası sonra 10 20 arası

    20
   /  \
  10   30



+  LL Rotasyonu: Sol alt ağacın sol dalındaki dengesizlik.
+ LR Rotasyonu: Sol alt ağacın sağ dalındaki dengesizlik.
+ RR Rotasyonu: Sağ alt ağacın sağ dalındaki dengesizlik.
+ RL Rotasyonu: Sağ alt ağacın sol dalındaki dengesizlik.


## Avl ne yapar?

Dengesizlik olan durumlarda rotasyonları yaparak dengeli bir ağaç yaratır