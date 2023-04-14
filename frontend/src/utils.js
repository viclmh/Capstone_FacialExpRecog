// const domain = "http://localhost:8080";
const domain = "https://capstone-383618.uk.r.appspot.com"


export const sumbitImage = (data) => {
    const url = `${domain}/image`

    return fetch(url, {
        method: 'POST',
        body: data
    }).then((res) => {
        if(res.status !== 200) {
            throw Error("Failed! Cannot get classification result.");
        }
        return res.json()
    }).then((data) => {
        return data
    })
}

