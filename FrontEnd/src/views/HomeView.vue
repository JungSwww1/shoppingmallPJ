<template>
  <div class="container">

    <iframe width="1300" height="500"
      src="https://www.youtube.com/embed/EtqQc9nCYmU?si=w39obANTjLSTaoeL&autoplay=1&loop=1" title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowfullscreen>
    </iframe>

    <br><br>

    <h1>SSAFYMALL 추천 잉끼상품!</h1>
    <div id="carouselExample" class="carousel slide">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="row">
            <RouterLink :to="`/productDetail/${purList[0].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[0].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[0].itemNm }}</p>
                <p class="detail card-text">{{ purList[0].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[0].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${purList[1].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[1].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[1].itemNm }}</p>
                <p class="detail card-text">{{ purList[1].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[1].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${purList[2].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[2].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[2].itemNm }}</p>
                <p class="detail card-text">{{ purList[2].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[2].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${purList[3].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[3].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[3].itemNm }}</p>
                <p class="detail card-text">{{ purList[3].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[3].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
          </div>
        </div>

        <div class="carousel-item">
          <div class="row">
            <RouterLink :to="`/productDetail/${purList[4].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[4].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[4].itemNm }}</p>
                <p class="detail card-text">{{ purList[4].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[4].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${purList[5].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[5].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[5].itemNm }}</p>
                <p class="detail card-text">{{ purList[5].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[5].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${purList[6].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[6].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[6].itemNm }}</p>
                <p class="detail card-text">{{ purList[6].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[6].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${purList[7].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="purList[7].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ purList[7].itemNm }}</p>
                <p class="detail card-text">{{ purList[7].itemDetail }}</p>
                <br />
                <p class="card-text">
                  {{
                    purList[7].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
          </div>
        </div>
      </div>

      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

    <h1>SSAFYMALL만의 따끈따끈한 신상품!</h1>
    <div id="carouselExample2" class="carousel slide">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="row">
            <RouterLink :to="`/productDetail/${newList[0].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[0].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[0].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[0].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[0].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${newList[1].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[1].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[1].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[1].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[1].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${newList[2].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[2].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[2].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[2].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[2].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${newList[3].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[3].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[3].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[3].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[3].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
          </div>
        </div>

        <div class="carousel-item">
          <div class="row">
            <RouterLink :to="`/productDetail/${newList[4].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[4].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[4].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[4].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[4].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${newList[5].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[5].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[5].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[5].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[5].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${newList[6].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[6].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[6].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[6].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[6].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${newList[7].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="newList[7].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ newList[7].itemNm }}</p>
                <p class="detail card-text">
                  등록일 : {{ newList[7].regTime }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    newList[7].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
          </div>
        </div>
      </div>

      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample2" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExample2" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

    <h1>재고 임박!! 많이 사가는 데는 이유가 있다!</h1>
    <div id="carouselExample3" class="carousel slide">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <div class="row">
            <RouterLink :to="`/productDetail/${stockList[0].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[0].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[0].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[0].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[0].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${stockList[1].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[1].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[1].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[1].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[1].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${stockList[2].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[2].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[2].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[2].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[2].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${stockList[3].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[3].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[3].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[3].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[3].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
          </div>
        </div>

        <div class="carousel-item">
          <div class="row">
            <RouterLink :to="`/productDetail/${stockList[4].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[4].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[4].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[4].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[4].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${stockList[5].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[5].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[5].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[5].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[5].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${stockList[6].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[6].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[6].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[6].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[6].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
            <RouterLink :to="`/productDetail/${stockList[7].id}`" class="card col" style="width: 18rem">
              <img height="160" width="100" :src="stockList[7].img" class="card-img-top" alt="image" />
              <div class="card-body">
                <p class="card-title">{{ stockList[7].itemNm }}</p>
                <p class="detail card-text">
                  재고량 : {{ stockList[7].stockNumber }}
                </p>
                <br />
                <p class="card-text">
                  {{
                    stockList[7].price
                      .toString()
                      .replace(/\B(?=(\d{3})+(?!\d))/g, ",")
                  }}
                </p>
                원
              </div>
            </RouterLink>
          </div>
        </div>
      </div>

      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample3" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExample3" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeMount, computed } from "vue";
import { useProductStore } from "@/stores/product";

const productStore = useProductStore();

const purList = computed(() => {
  return productStore.purProductList;
});

const stockList = computed(() => {
  return productStore.stockProductList;
});

const newList = computed(() => {
  return productStore.newProductList;
});

// 페이지 켜지면 조건에 맞는 리스트들 뽑아옴

onBeforeMount(() => {
  productStore.getPurProductList();
  productStore.getStockProductList();
  productStore.getNewProductList();
});
</script>

<style scoped>
iframe {
  margin: 0 auto;
}

.row {
  flex: inline;
  height: 400px;
}

.carousel-item {
  flex: inline;
}

.col {
  height: 300px;
  width: 100px;
}

.card-text {
  display: inline;
  font-size: 25px;
  /* font-weight: bold; */
}

.card-title {
  font-size: 18px;
}

.card {
  text-decoration: none;
  margin: 20px 21px 60px;
}

.detail {
  font-size: 80%;
  font-weight: none;
}

h1 {
  font-weight: bold;
  text-align: center;
}

.carousel-control-prev-icon {
  fill: black;
  background-color: gray;
  border-radius: 50%;
  margin-right: 120px;
}

.carousel-control-next-icon {
  fill: black;
  background-color: gray;
  border-radius: 50%;
  margin-left: 120px;
}

.carousel {
  width: 80%;
  margin: 0 auto;
}
</style>
