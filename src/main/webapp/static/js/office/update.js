let vm = new Vue({
    el: "#main-container",
    data: {
        obj: {

        }
    },
    methods: {
        update: function (check) {
            this.obj.check = check;
            axios({
                url: "",
                method: "post",
                data: this.obj
            }).then(response => {

                console.log(response.data)
                parent.layer.msg(response.data.msg)
                let index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            }).catch(function (error) {
                console.log(error)
            })
        }
    },
    created: function () {
        this.obj = parent.layer.obj;
    }
})