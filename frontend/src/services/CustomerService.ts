import { BASE_URL } from "../utils/Request";

interface DataLogin {
  cpf: string,
  password: string
}

export async function loginByCpfAndPassword(data: DataLogin) {
  const request = await fetch(`${BASE_URL}/customers/login-by-cpf-and-password`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "accept": "application/json",
    },
    body: JSON.stringify({ ...data }),
  })
  .then((response) => response.json())
  .then((data) => data)
  .catch((e) => e);

  if (request.message) {
    throw new Error(request.message);
  }

  return request;
}