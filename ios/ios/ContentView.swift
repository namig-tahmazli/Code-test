import SwiftUI
import shared
import UIKit

struct SharedView : UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainViewControllerKt.MainViewController()
    }
}

struct ContentView : View {
    var body: some View {
        SharedView()
            .ignoresSafeArea(.all)
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView()
	}
}
