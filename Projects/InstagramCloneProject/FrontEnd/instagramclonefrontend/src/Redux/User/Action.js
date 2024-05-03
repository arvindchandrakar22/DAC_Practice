import { REQ_USER } from "./ActionType";

export const getUserProfileAction = (jwt) => async (disppatch) => {
  try {
    const res = await fetch("http://localhost:8888/api/users/req", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: "Bearer " + jwt,
      },
    });

    const reqUser = await res.json();
    disppatch({ type: REQ_USER, payload: reqUser });
  } catch (error) {
    console.log("catch :", error);
  }
};
