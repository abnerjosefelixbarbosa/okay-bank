import { useContext } from "react";
import { MyContext } from "../components/Context";

export function useProps() {
  const context = useContext(MyContext);
  return context;
}
