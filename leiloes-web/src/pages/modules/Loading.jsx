import styles from "../css/loading.module.css"

const loading = () => {
  return (
    <>
        <div className={styles.area_loading}>
            <div className={styles.custom_loader}></div>
        </div>
    </>
  )
}

export default loading