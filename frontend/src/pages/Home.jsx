import { Fragment } from "react";
import Wrapper from "../components/wrapper/Wrapper";
import Section from "../components/Section";
import { products, discoutProducts } from "../utils/products";
import SliderHome from "../components/Slider";
import useWindowScrollToTop from "../hooks/useWindowScrollToTop";

const Home = () => {
  const newArrivalData = products.filter(
    (item) => item.category === "mobile" || item.category === "wireless"
  );
  const bestSales = products.filter((item) => item.category === "sofa");
  useWindowScrollToTop();
  return (
    <Fragment>
      <SliderHome />
      <Wrapper />
      <Section
        title="BIG DISSCOUNT"
        bgColor="#f6f9fc"
        productItems={discoutProducts}
      />
      <Section
        title="NEW ARRIVALS"
        bgColor="white"
        productItems={newArrivalData}
      />
      <Section title="BEST SALES" bgColor="#f6f9fc" productItems={bestSales} />
    </Fragment>
  );
};

export default Home;
