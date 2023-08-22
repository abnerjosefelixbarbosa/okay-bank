import { useContext } from "react";
import { MyContext } from "../context";

export function useProps() {
  const context = useContext(MyContext);
  return context;
}
